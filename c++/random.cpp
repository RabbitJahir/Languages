#include <QApplication>
#include <QPushButton>

int main(int argc, char *argv[]) {
    // 1. Initialize the application infrastructure
    QApplication app(argc, argv);

    // 2. Create a clickable button widget
    QPushButton button("Hello, World!");
    button.resize(200, 60);
    button.show();

    // 3. Start the application main event loop
    return app.exec();
}

Option 1: Using Qt Creator (Recommended)
Install the Qt SDK and Qt Creator from the official Qt website.
Open Qt Creator.
Create a new project:
File → New Project → Application → Qt Widgets Application
Replace the generated main.cpp with your code: