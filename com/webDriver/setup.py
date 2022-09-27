import tkinter
from tkinter import ttk

# use tkinter to get user input
window = tkinter.Tk()
window.title("FlexiSCHED Scheduler")
window.geometry('300x200')

def new_sched():
    window.destroy()

    window2 = tkinter.Tk()
    window2.title("FlexiSCHED Scheduler")

    # get user input for new schedule
    tkinter.Label(text="Enter Details for Schedule Below").grid(row=0, column=1, columnspan=3)
    tkinter.Label(text="Tuesday").grid(row=1, column=0)
    tkinter.Label(text="Wednesday").grid(row=1, column=1)
    tkinter.Label(text="Thursday").grid(row=1, column=2)
    tkinter.Label(text="Friday").grid(row=1, column=3)

    tlist = ["default",
             "Sarbacker"]

    var, var2, var3, var4 = tkinter.StringVar(), tkinter.StringVar(), tkinter.StringVar(), tkinter.StringVar()

    ttk.OptionMenu(window2, var, "default", *tlist).grid(row=2, column=0)
    ttk.OptionMenu(window2, var2, "default", *tlist).grid(row=2, column=1)
    ttk.OptionMenu(window2, var3, "default", *tlist).grid(row=2, column=2)
    ttk.OptionMenu(window2, var4, "default", *tlist).grid(row=2, column=3)

    def save():
        # save schedule to the directory
        file = open("schedule.txt", "w")
        file.write(email.get() + "\n" + password.get() + "\n")
        file.write(var.get() + "\n" + var2.get() + "\n" + var3.get() + "\n" + var4.get())
        file.close()
        window2.destroy()

    tkinter.Button(text="Submit", command=lambda: save()).grid(row=3, column=2)

    window2.mainloop()

email = tkinter.StringVar()
password = tkinter.StringVar()

tkinter.Label(text="Welcome to FlexiSCHED Scheduler").pack()
tkinter.Label(text="").pack()
tkinter.Label(text="Please input your email and password below").pack()
tkinter.Entry(textvariable=email).pack()
tkinter.Entry(textvariable=password, show="*").pack()
tkinter.Button(text="Submit", command=lambda: new_sched()).pack()

window.mainloop()