while True:
    choice1 = input("Enter Choice1 from rock, paper or scissors? ").lower()
    choice2 = input("Enter Choice2 from rock, paper or scissors? ").lower()

    if choice1 == choice2:
        print("It's a tie!")
    elif choice1 == 'rock':
        if choice2 == 'scissors':
            print("Rock wins!")
        else:
            print("Paper wins!")
    elif choice1 == 'scissors':
        if choice2 == 'paper':
            print("Scissors win!")
        else:
            print("Rock wins!")
    elif choice1 == 'paper':
        if choice2 == 'rock':
            print("Paper wins!")
        else:
            print("Scissors win!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")

    play = input("Do you want to play more? (y/n): ").lower()

    if(play == "y"):
        continue
    else:
        raise SystemExit