# VisualKeyboard

## 專案介紹
VisualKeyboard 是一個用 Java Swing 實作的視覺化鍵盤程式。使用者可以在文字區輸入文字，並且程式會即時高亮對應鍵盤按鍵，方便觀察鍵盤輸入行為。

---

## 功能特色
- 顯示完整鍵盤按鍵（包含字母、數字、符號與特殊按鍵）
- 按鍵按下時，對應按鈕會變色高亮
- 支援 Backspace、Tab、Caps Lock、Enter、Shift、方向鍵、空白鍵等特殊鍵
- 文字輸入會顯示在文字區域，支援多行滾動

---

## 專案結構
```text
VisualKeyboard/
│-- Main.java
│-- VisualKeyboardFrame.java
│-- Makefile
│-- README.md
```

## 使用說明
1. 下載程式碼或使用 Git Clone：
```bash
git clone <你的 GitHub 專案連結>
```
2. 在 Windows 環境中，使用 Makefile 編譯與執行：

```bash
make run
```
或手動編譯:
```bash
javac Main.java VisualKeyboardFrame.java
java Main
```
3.關閉程式視窗即可結束程式。
