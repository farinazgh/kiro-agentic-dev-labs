"""Kiro UserPromptSubmit hook: keep a local JSON array of submitted prompts.

Uses Python's standard library. Kiro provides USER_PROMPT in the environment;
the stdin event payload is used only as a fallback.
"""

import json
import os
from datetime import datetime, timezone
from pathlib import Path
import sys
import tempfile


def main():
    prompt = os.environ.get("USER_PROMPT", "")
    if not prompt:
        try:
            payload = json.load(sys.stdin)
            if isinstance(payload, dict):
                prompt = (payload.get("prompt") or payload.get("user_prompt")
                          or payload.get("message") or "")
        except (ValueError, OSError):
            pass

    if not isinstance(prompt, str) or not prompt.strip():
        print("No user prompt received; nothing saved.")
        return

    output_file = Path.cwd() / ".kiro" / "local" / "prompt-history.json"
    output_file.parent.mkdir(parents=True, exist_ok=True)
    records = []
    if output_file.exists():
        records = json.loads(output_file.read_text(encoding="utf-8"))
        if not isinstance(records, list):
            raise ValueError("Existing prompt-history.json must contain a JSON array")

    records.append({
        "timestamp": datetime.now(timezone.utc).isoformat(),
        "prompt": prompt,
    })

    # Replace the JSON file atomically to avoid partial writes on interruption.
    temp_path = None
    try:
        with tempfile.NamedTemporaryFile(mode="w", encoding="utf-8", suffix=".tmp",
                                         dir=output_file.parent, delete=False) as f:
            temp_path = Path(f.name)
            json.dump(records, f, ensure_ascii=False, indent=2)
            f.write("\n")
        os.replace(temp_path, output_file)
    finally:
        if temp_path is not None:
            temp_path.unlink(missing_ok=True)

    print(f"Saved prompt locally ({len(records)} entries).")


if __name__ == "__main__":
    main()
