# Claude Dokumentations-Anleitung für LeetCode Lösungen

## Aufgabe
Wenn du gebeten wirst, "documentation" oder "Dokumentation hinzuzufügen", führe folgende Schritte aus:

## 1. File-Auswahl
- **Standard**: Dokumentiere die neueste File (höchste Nummer)
- **Spezifisch**: Wenn eine bestimmte File genannt wird, dokumentiere diese

## 2. Kommentare in der Code-File

### Inspiration & Format
- Schaue dir die **File mit der nächst-kleineren Nummer** als Referenz an
- Übernimm den gleichen Kommentarstil und die gleiche Struktur
- Alle Files folgen einem ähnlichen Muster (LeetCode-Lösungen)

### Was zu kommentieren
- **Funktionszweck**: Was macht die Lösung?
- **Algorithmus-Ansatz**: Welche Strategie wird verwendet?
- **Komplexität**: Time & Space Complexity
- **Wichtige Schritte**: Kommentiere komplexe Logik-Abschnitte
- **Edge Cases**: Falls behandelt

## 3. README.md Update

### Format
- Füge einen neuen Paragraph im **letzten Heading** hinzu
- Übernimm das **exakte Format des letzten Eintrags**

### Inhalt des Paragraphs
1. **Name der LeetCode-Aufgabe**: Offizieller Titel
2. **Aufgaben-Beschreibung**: Kurze Info/Zusammenfassung
3. **Time Complexity**: Analysiere den Code und gib die Time Complexity an (z.B. O(n), O(log n), O(n²))
4. **Space Complexity**: Optional, falls in anderen Einträgen auch vorhanden
5. **File-Referenz**: Link oder Verweis auf die dokumentierte File

### Beispiel-Format (basierend auf vorhandenen Einträgen):
```markdown
**[Nummer]. [LeetCode Aufgaben-Name]**
- Beschreibung: [Kurze Erklärung des Problems]
- Time Complexity: O(?)
- Space Complexity: O(?)
- File: `problem_[nummer].java`
```

## 4. Konsistenz
- Halte dich **strikt** an den Stil der vorhandenen Dokumentation
- Achte auf die **gleiche Sprache** (Deutsch/Englisch) wie in bestehenden Kommentaren
- Verwende die **gleichen Formatierungen** (Markdown, Einrückungen, etc.)

## Beispiel-Workflow
```
User: "documentation adden"
→ Öffne neueste File (z.B. problem_15.java)
→ Schaue problem_14.java als Referenz an
→ Füge Kommentare zu problem_15.java hinzu
→ Analysiere Time Complexity von problem_15.java
→ Füge Eintrag in README.md hinzu (gleiches Format wie problem_14)
```

## Wichtig
- **Keine Fragen stellen**, sondern direkt loslegen
- Bei Unklarheiten: Orientiere dich an der letzten dokumentierten File
- **Time Complexity muss korrekt analysiert werden** - nicht raten!