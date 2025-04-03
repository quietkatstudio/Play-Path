---
name: getSongs
about: no longer taking in data for noteList when making a song
title: ''
labels: bug
assignees: ''

---

When running scenario2, getSongByTitles, not longer gets a complete Song and is missing the collection of note data. Without the notes the song doesn't play resulting in scenario 2 failing. After using the VSCode debugging tool it seems to be tied to a problem in getSongs somewhere.
