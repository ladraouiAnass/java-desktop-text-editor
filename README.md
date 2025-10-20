# 📝 Advanced Java Swing Text Editor

> **Master Java with Swing** - A feature-rich desktop text editor that rivals Microsoft Notepad with advanced formatting capabilities and modern UI design.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

## 🌟 Features

### 📄 **File Management**
- **Multi-tab Interface** - Work with multiple documents simultaneously
- **Smart File Operations** - Open, save, and save-as with formatted text preservation
- **Color-aware Saving** - Save documents with complete formatting (fonts, colors, styles)
- **Auto-save Support** - Quick save with `Ctrl+S`

### 🎨 **Advanced Text Formatting**
- **Rich Font Support** - 20+ professional fonts including Arial, Times New Roman, Helvetica
- **Dynamic Font Sizing** - Adjustable font sizes from 8pt to 72pt
- **Color Customization** - Full color picker for text and background
- **Theme Support** - Light and dark mode themes
- **Live Preview** - Real-time formatting preview

### 🔍 **Powerful Search & Replace**
- **Advanced Find** - Search with navigation (next/previous)
- **Smart Replace** - Replace individual or all occurrences
- **Highlight Matching** - Visual highlighting of search results
- **Case-sensitive Options** - Flexible search parameters

### ⌨️ **Keyboard Shortcuts**
| Shortcut | Action |
|----------|--------|
| `Ctrl+N` | New tab |
| `Ctrl+Shift+N` | New window |
| `Ctrl+O` | Open file |
| `Ctrl+S` | Save file |
| `Ctrl+Shift+S` | Save as |
| `Ctrl+Alt+S` | Save all tabs |
| `Ctrl+F` | Find text |
| `Ctrl+Shift+F` | Font formatting |
| `Ctrl+W` | Close tab |
| `Ctrl+Shift+W` | Close window |
| `Ctrl+Space` | Zoom in |
| `Ctrl+-` | Zoom out |

### 🎯 **User Experience**
- **Intuitive Interface** - Clean, modern Swing-based GUI
- **Tab Management** - Easy navigation between multiple documents
- **Zoom Controls** - Adjustable text size for better readability
- **System Integration** - Native look and feel adaptation

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command line

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd java-desktop-text-editor
   ```

2. **Compile the project**
   ```bash
   javac *.java
   ```

3. **Run the application**
   ```bash
   java program
   ```

## 📁 Project Structure

```
java-desktop-text-editor/
├── program.java          # Main entry point
├── Window.java           # Main application window
├── MainPanel.java        # Document panel container
├── Zone.java             # Text editing area with rich formatting
├── Tabs.java             # Tab management system
├── MyMenu.java           # Menu bar implementation
├── FileMenu.java         # File operations menu
├── EditMenu.java         # Edit operations menu
├── ViewMenu.java         # View options menu
├── FileOperations.java   # File I/O operations
├── EditOperations.java   # Text editing operations
├── FFont.java            # Font selection dialog
├── FontPanel.java        # Font customization panel
├── FontStyleChooser.java # Font style selection
├── SelectZone.java       # Text selection utilities
└── preview/              # Application screenshots
    ├── exemple1.png
    ├── exemple2.png
    └── ...
```

## 🎨 Screenshots

The `preview/` folder contains 8 example screenshots showcasing:
- Multi-tab interface
- Font formatting dialog
- Dark/Light theme modes
- Search and replace functionality
- File operations
- Text formatting options

## 🔧 Technical Highlights

### **Object-Oriented Design**
- **Modular Architecture** - Separated concerns with dedicated classes
- **Event-Driven Programming** - Comprehensive keyboard and mouse event handling
- **Swing Components** - Professional GUI using JFrame, JPanel, JTextPane
- **File Serialization** - Advanced save/load with formatting preservation

### **Advanced Features**
- **Rich Text Support** - JTextPane for formatted text editing
- **Color Management** - RGB color selection and theme switching
- **Font Rendering** - Dynamic font loading and rendering
- **Memory Management** - Efficient handling of multiple documents

## 🎓 Learning Objectives

This project demonstrates mastery of:

- **Java Swing GUI Development**
- **Event Handling & Listeners**
- **File I/O Operations**
- **Object Serialization**
- **Layout Management**
- **Multi-threading Concepts**
- **Design Patterns (Observer, MVC)**
- **Exception Handling**

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Built with Java Swing framework
- Inspired by modern text editors like Notepad++, Sublime Text
- Designed for educational purposes to master Java GUI development

---

**⭐ Star this repository if it helped you learn Java Swing!**

*Happy Coding! 🚀*