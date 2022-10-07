#include <iostream>

int main()
{
    int myAge = 0;
    std::cout << "Enter your age: ";
    std::cin >> myAge;
    std::cout << "Your age is " << myAge << std::endl;

    if (myAge >= 18)
    {
        std::cout << "You are an adult" << std::endl;

        while (myAge < 65)
        {
            myAge++;
            std::cout << "Your age is " << myAge << std::endl;
        }

        std::cout << "You are retired" << std::endl;
    }
    else
    {
        std::cout << "You are a child" << std::endl;
    }

    return 0;
}