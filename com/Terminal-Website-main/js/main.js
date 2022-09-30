var user = "guest";

var rootAccess = false;

var root = {
    "about.txt": "My name is cooper recob",
    "contact.txt": 'You can contact me at:\n<a href="crecob1@gmail.com">crecob1@gmail.com</a>'
};

var currentDir = root;
var tempDir = [];

$.terminal.new_formatter([
    /<a href="([^"]+)">([^>]+)<\/a>/g, '[[!gb;orange;;;$1]$2]'
]);

$("body").terminal(
    {
        iam: function (name) {
            if (name == "iwantroot") {
                user = "root";
                rootAcess = true;
                this.set_prompt("root@crterminal:~# ");
                this.echo("You are now at root level. Use it wisely.");
            } else if (name != "") {
                user = name.toLowerCase();
                this.echo("Welcome, " + name + ".");
                this.set_prompt(user + "@crterminal:~$ ");
            }
        },
        whoami: function () {
            this.echo(user);
        },
        ls: function () {
            var list = "../";
            for (var file in currentDir) {
                list += "\n" + file;
            }
            this.echo(list);
        },
        cat: function (file) {
            if (file in currentDir && typeof currentDir[file] == "string") {
                this.echo(currentDir[file]);
            } else {
                this.echo("File not found.");
            }
        },
        cd: function (newDir) {
            if (newDir == "../") {
                if (currentDir == root) {
                    this.echo("You are in the root directory.");
                } else {
                    currentDir = tempDir[tempDir.length - 1];
                    tempDir.pop();
                    this.echo("You are in the previous folder.");
                    tempDir.pop();
                }
            } else if (newDir in currentDir) {
                tempDir.push(currentDir);
                currentDir = currentDir[newDir];
                this.echo("You are now in the " + newDir + " directory.");
            } else {
                this.echo("Directory not found.");
            }
        },
        clear: function () {
            this.clear();
        },
        banner: function () {
            this.echo(greetings);
        },
        secret: function () {
            if (rootAccess = true) {
                this.echo("Never gonna give you up");
            } else {
                this.echo("You don't have access to this command.");
            }
        },
        meow: function () {
            this.echo("meow");
        },
        help: function () {
            this.echo(
                "[[bg;orange;black]iam] - changes the user\n" +
                "[[bg;orange;black]whoami] - prints the user\n" +
                "[[bg;orange;black]help] - prints this message\n" +
                "[[bg;orange;black]ls] - lists the files\n" +
                "[[bg;orange;black]cat] - prints the contents of a file\n" +
                "[[bg;orange;black]cd] - changes the directory\n" +
                "[[bg;orange;black]clear] - clears the terminal"
            );
        },
    },
    {
        greetings:
            "[[bg;green;black]  /$$$$$$  /$$$$$$$   /$$$$$$$$ /$$$$$$$$ /$$$$$$$  /$$      /$$ /$$$$$$ /$$   /$$  /$$$$$$  /$$      \n" +
            " /$$__  $$| $$__  $$ |__  $$__/| $$_____/| $$__  $$| $$$    /$$$|_  $$_/| $$$ | $$ /$$__  $$| $$      \n" +
            "| $$  \\__/| $$  \\ $$    | $$   | $$      | $$  \\ $$| $$$$  /$$$$  | $$  | $$$$| $$| $$  \\ $$| $$      \n" +
            "| $$      | $$$$$$/     | $$   | $$$$$   | $$$$$$/ | $$ $$/$$ $$  | $$  | $$ $$ $$| $$$$$$$$| $$      \n" +
            "| $$      | $$__  $$    | $$   | $$__/   | $$__  $$| $$  $$$| $$  | $$  | $$  $$$$| $$__  $$| $$      \n" +
            "| $$    $$| $$  \\ $$    | $$   | $$      | $$  \\ $$| $$\\  $ | $$  | $$  | $$\\  $$$| $$  | $$| $$      \n" +
            "|  $$$$$$/| $$  | $$    | $$   | $$$$$$$$| $$  | $$| $$ \\/  | $$ /$$$$$$| $$ \\  $$| $$  | $$| $$$$$$$$\n" +
            " \\______/ |__/  |__/    |__/   |________/|__/  |__/|__/     |__/|______/|__/  \\__/|__/  |__/|________/]\n\n" +
            "Welcome to the terminal.\n" +
            "Type '[[bg;orange;black]help]' for a list of commands.",
        prompt: "guest@crterminal:~$ ",
    }
);
