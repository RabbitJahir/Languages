package main

import (
	"path/filepath"
	"bufio"
	"fmt"
	"math"
	"os"
	"runtime"
	"strconv"
	"strings"
)

// ─── Data ──────────────────────────────────────────────────────────────────────

type User struct {
	Username    string
	Password    string
	AccountType string
	Mobile      string
	Balance     float64
	Loan        float64
}

type Storage struct {
	users map[string]*User
}

func dataFile() string {
	exe, err := os.Executable()
	if err != nil {
		return "users.txt"
	}
	return filepath.Join(filepath.Dir(exe), "users.txt")
}

func NewStorage() *Storage {
	s := &Storage{users: make(map[string]*User)}
	s.load()
	return s
}

func (s *Storage) load() {
	f, err := os.Open(dataFile())
	if err != nil {
		fmt.Println("No previous data found. Starting fresh.")
		return
	}
	defer f.Close()

	sc := bufio.NewScanner(f)
	for sc.Scan() {
		parts := strings.Split(sc.Text(), ",")
		if len(parts) != 6 {
			continue
		}
		bal, _ := strconv.ParseFloat(parts[4], 64)
		loan, _ := strconv.ParseFloat(parts[5], 64)
		u := &User{parts[0], parts[1], parts[2], parts[3], bal, loan}
		s.users[u.Username] = u
	}
}

func (s *Storage) save() {
	f, err := os.Create(dataFile())
	if err != nil {
		red("Error saving file.")
		return
	}
	defer f.Close()

	w := bufio.NewWriter(f)
	for _, u := range s.users {
		fmt.Fprintf(w, "%s,%s,%s,%s,%.2f,%.2f\n",
			u.Username, u.Password, u.AccountType, u.Mobile, u.Balance, u.Loan)
	}
	w.Flush()
	green("Data saved successfully.")
}

func (s *Storage) login(username, password string) *User {
	u := s.users[username]
	if u != nil && u.Password == password {
		return u
	}
	return nil
}

func (s *Storage) createUser(username, password, accountType, mobile string, balance float64) bool {
	if _, exists := s.users[username]; exists {
		red("Username already exists!")
		return false
	}
	s.users[username] = &User{username, password, accountType, mobile, balance, 0}
	green("Account created successfully!")
	return true
}

func (s *Storage) getUser(username string) *User {
	return s.users[username]
}

func (s *Storage) exists(username string) bool {
	_, ok := s.users[username]
	return ok
}

// ─── Terminal helpers ───────────────────────────────────────────────────────────

func bold(s string) string  { return "\033[1m" + s + "\033[0m" }
func green(s string)        { fmt.Println("\033[32m" + s + "\033[0m") }
func red(s string)          { fmt.Println("\033[1m\033[31m" + s + "\033[0m") }
func yellow(s string)       { fmt.Println("\033[1m\033[33m" + s + "\033[0m") }
func cyan(s string)         { fmt.Println("\033[1m\033[34m" + s + "\033[0m") }
func money(v float64) string { return fmt.Sprintf("$%.2f", v) }

func clearScreen() {
	if runtime.GOOS == "windows" {
		fmt.Print("\033[H\033[2J")
	} else {
		fmt.Print("\033[H\033[2J")
	}
	os.Stdout.Sync()
}

func pause(r *bufio.Reader) {
	fmt.Println(bold("\n\033[32mPress Enter to continue..."))
	r.ReadString('\n')
	clearScreen()
}

func readLine(r *bufio.Reader) string {
	line, _ := r.ReadString('\n')
	return strings.TrimSpace(line)
}

func readFloat(r *bufio.Reader) (float64, error) {
	s := readLine(r)
	return strconv.ParseFloat(s, 64)
}

func readInt(r *bufio.Reader) (int, error) {
	s := readLine(r)
	return strconv.Atoi(s)
}

// ─── Screens ───────────────────────────────────────────────────────────────────

func homeScreen() {
	fmt.Println("-----------------------------")
	fmt.Println("     WELCOME TO BANK")
	fmt.Println("-----------------------------")
	fmt.Println("1. Login\n")
	fmt.Println("2. Create account\n")
	fmt.Println("3. Change password\n")
	fmt.Println("0. Exit\n")
	fmt.Print("Enter your choice: ")
}

func userHub(username string) {
	fmt.Println(bold("-----------------------------"))
	fmt.Printf(bold("    Welcome %s\n"), username)
	fmt.Println(bold("-----------------------------"))
	fmt.Println(bold("1. Detailed Information"))
	fmt.Println(bold("2. Check Balance"))
	fmt.Println(bold("3. Take Loan"))
	fmt.Println(bold("4. Repay Loan"))
	fmt.Println(bold("5. Withdraw from Balance"))
	fmt.Println(bold("6. Deposit into Balance"))
	fmt.Println(bold("7. Transfer Balance"))
	fmt.Println(bold("8. Exit\n"))
	fmt.Print("Choose: ")
}

func loanRulesPersonal() {
	fmt.Println("1. A user can only have one active loan at a time.")
	fmt.Println("2. Loan amount must be between $100 and $50,000.")
	fmt.Println("3. A fixed 20% interest is added once when the loan is approved.")
	fmt.Println("4. Loan durations are 3, 6, 12, 24 months.")
	fmt.Println("5. Monthly payments must be paid before due date, otherwise 10% interest will be added.")
	fmt.Println("6. Users cannot take another loan until the current loan is fully paid.")
	fmt.Println()
	fmt.Println(bold("Enter 0 to go back."))
}

func loanRulesSaving() {
	fmt.Println("1. A user can only have one active loan at a time.")
	fmt.Println("2. Loan amount must be between $100 and $7,000.")
	fmt.Println("3. A fixed 13% interest is added once when the loan is approved.")
	fmt.Println("4. Loan durations are 3, 6, 12, 24 months.")
	fmt.Println("5. Monthly payments must be paid before due date, otherwise 10% interest will be added.")
	fmt.Println("6. Users cannot take another loan until the current loan is fully paid.")
	fmt.Println()
	fmt.Println(bold("Enter 0 to go back."))
}

// ─── Features ──────────────────────────────────────────────────────────────────

func handleLogin(r *bufio.Reader, s *Storage) *User {
	fmt.Println("-----------------------------")
	fmt.Println("  LOGGING IN")
	fmt.Println("-----------------------------")

	fmt.Print("Enter Account Name: ")
	username := readLine(r)

	fmt.Print("Enter Password: ")
	password := readLine(r)

	u := s.login(username, password)
	if u == nil {
		red("\nUser not found or password wrong.")
		red("Login failed. Try again.")
	}
	return u
}

func handleCreate(r *bufio.Reader, s *Storage) {
	fmt.Println("-----------------------------")
	fmt.Println("  CREATING ACCOUNT")
	fmt.Println("-----------------------------")
	fmt.Println("1. Personal account:")
	fmt.Println("   - $500 initial deposit.\n")
	fmt.Println("2. Savings account:")
	fmt.Println("   - No initial deposit.\n")
	fmt.Print("Select account type: ")

	choice, err := readInt(r)
	if err != nil || (choice != 1 && choice != 2) {
		red("Invalid Input")
		return
	}

	// Username
	var username string
	for {
		fmt.Print("Enter username: ")
		username = readLine(r)
		if username != "" {
			break
		}
		fmt.Println("Username cannot be empty!")
	}

	// Password
	var password string
	for {
		fmt.Print("Enter password: ")
		password = readLine(r)
		if password != "" {
			break
		}
		fmt.Println("Password cannot be empty!")
	}

	// Mobile
	var mobile string
	for {
		fmt.Print("Enter mobile number: ")
		mobile = readLine(r)
		if mobile != "" && isDigits(mobile) {
			break
		}
		fmt.Println("Mobile must contain numbers only and cannot be empty!")
	}

	var accountType string
	var balance float64

	switch choice {
	case 1:
		accountType = "personal"
		for {
			fmt.Print("Deposit $500 minimum: ")
			bal, err := readFloat(r)
			if err != nil {
				red("Numbers only.")
				continue
			}
			if bal >= 500 {
				balance = bal
				break
			}
			fmt.Println("Must deposit at least $500.")
		}
	case 2:
		accountType = "saving"
		balance = 0
	}

	if s.createUser(username, password, accountType, mobile, balance) {
		s.save()
	}
}

func handleChangePassword(r *bufio.Reader, s *Storage) {
	fmt.Println("-----------------------------")
	fmt.Println("  CHANGING PASSWORD")
	fmt.Println("-----------------------------")

	fmt.Print("Enter username: ")
	username := readLine(r)

	fmt.Print("Enter mobile number: ")
	mobile := readLine(r)

	u := s.getUser(username)
	if u == nil || u.Mobile != mobile {
		red("Mobile number or Username does not match.")
		return
	}

	fmt.Print("Enter new password: ")
	newPass := readLine(r)
	u.Password = newPass
	s.save()
	yellow("Successfully changed password")
}

func handleTakeLoan(r *bufio.Reader, s *Storage, u *User) {
	if u.Loan != 0 {
		red("Pay previous loan first!")
		return
	}

	if u.AccountType == "personal" {
		loanRulesPersonal()
	} else {
		loanRulesSaving()
	}

	fmt.Print("\n\nAmount for loan: ")
	amount, err := readFloat(r)
	if err != nil {
		red("Numbers only.")
		return
	}

	if amount == 0 {
		return
	}
	if amount < 0 {
		red("Invalid amount")
		return
	}
	if u.AccountType == "personal" && (amount < 100 || amount > 50000) {
		red("Invalid amount")
		return
	}
	if u.AccountType == "saving" && (amount < 100 || amount > 7000) {
		red("Invalid amount")
		return
	}

	var interest float64
	if u.AccountType == "personal" {
		interest = amount * 1.20
	} else {
		interest = amount * 1.13
	}
	// round to 2 decimal places
	interest = math.Round(interest*100) / 100

	fmt.Print("\nTotal duration to repay in months (3, 6, 12, 24): ")
	duration, err := readInt(r)
	if err != nil {
		red("Numbers only.")
		return
	}

	if duration != 3 && duration != 6 && duration != 12 && duration != 24 {
		red("Duration must be 3, 6, 12, or 24 months.")
		return
	}

	u.Loan = interest
	s.save()
	green("Successfully loan given.")

	fmt.Printf("\nCurrent balance: %s\n", money(u.Balance))
	fmt.Printf("Current loan:    %s\n\n", money(u.Loan))
}

func handleRepayLoan(r *bufio.Reader, s *Storage, u *User) {
	if u.Loan == 0 {
		yellow("Currently no loan.")
		return
	}

	fmt.Printf("Current loan: %s\n\n", money(u.Loan))
	fmt.Println("1. Pay using cash")
	fmt.Println("2. Pay using bank balance")
	fmt.Println(bold("Enter 0 to go back.\n"))
	fmt.Print("Option: ")

	choice, err := readInt(r)
	if err != nil || choice == 0 {
		return
	}

	fmt.Printf("\nCurrent balance: %s\n", money(u.Balance))
	fmt.Print("Amount repaying: ")
	amount, err := readFloat(r)
	if err != nil {
		red("Numbers only.")
		return
	}

	if amount == 0 {
		return
	}
	if amount < 0 {
		red("Invalid amount")
		return
	}
	if amount > u.Loan {
		red("Amount exceeds loan.")
		return
	}

	if choice == 2 {
		if amount > u.Balance {
			red("Insufficient balance.")
			return
		}
		u.Balance -= amount
	}
	u.Loan -= amount
	u.Loan = math.Round(u.Loan*100) / 100
	s.save()
	fmt.Println("Loan repaid.")

	fmt.Printf("Current loan:    %s\n", money(u.Loan))
	fmt.Printf("Current balance: %s\n\n", money(u.Balance))
}

func handleWithdraw(r *bufio.Reader, s *Storage, u *User) {
	fmt.Printf("\n\033[34mCurrent balance:\033[0m %s\n\n", money(u.Balance))
	fmt.Println(bold("Enter 0 to go back.\n"))
	fmt.Print("Give an amount to withdraw: ")

	amount, err := readFloat(r)
	if err != nil {
		red("Numbers only.")
		return
	}

	if amount == 0 {
		return
	}
	if amount < 0 {
		red("Invalid amount")
		return
	}
	if amount >= u.Balance {
		red("Insufficient balance.")
		return
	}
	if u.Balance-amount < 100 {
		red("Must keep at least $100 in account.")
		return
	}

	u.Balance -= amount
	s.save()
	fmt.Printf("\nCurrent balance: %s\n", money(u.Balance))
}

func handleDeposit(r *bufio.Reader, s *Storage, u *User) {
	fmt.Printf("\n\033[34mCurrent balance:\033[0m %s\n\n", money(u.Balance))
	fmt.Println(bold("Enter 0 to go back.\n"))
	fmt.Print("Give an amount to deposit: ")

	amount, err := readFloat(r)
	if err != nil {
		red("Numbers only.")
		return
	}

	if amount == 0 {
		return
	}
	if amount < 0 {
		red("Invalid amount")
		return
	}

	u.Balance += amount
	s.save()
	fmt.Printf("\nCurrent balance: %s\n", money(u.Balance))
}

func handleTransfer(r *bufio.Reader, s *Storage, u *User) {
	fmt.Printf("Current balance: %s\n\n", money(u.Balance))
	fmt.Println(bold("Enter \"back\" to go back."))

	for {
		fmt.Print("Enter username of the recipient: ")
		recipient := readLine(r)

		if recipient == "" {
			red("Invalid input.")
			continue
		}
		if recipient == "back" {
			break
		}
		if recipient == u.Username {
			red("Username is identical to yourself.")
			continue
		}
		if !s.exists(recipient) {
			red("User not found.")
			continue
		}

		green("User found!")
		fmt.Print("Enter amount to transfer: ")

		amount, err := readFloat(r)
		if err != nil {
			red("Numbers only.")
			continue
		}

		if amount > u.Balance {
			red("Insufficient balance.")
			continue
		}

		target := s.getUser(recipient)
		u.Balance -= amount
		target.Balance += amount
		s.save()
		green("Transfer successful.")
		break
	}

	fmt.Printf("\nCurrent balance: %s\n", money(u.Balance))
}

// ─── Helpers ───────────────────────────────────────────────────────────────────

func isDigits(s string) bool {
	for _, c := range s {
		if c < '0' || c > '9' {
			return false
		}
	}
	return true
}

// ─── Main ──────────────────────────────────────────────────────────────────────

func main() {
	r := bufio.NewReader(os.Stdin)
	s := NewStorage()

	var currentUser *User

	// ── Login loop ──
	for {
		clearScreen()
		homeScreen()

		choice, err := readInt(r)
		if err != nil {
			continue
		}
		clearScreen()

		switch choice {
		case 0:
			fmt.Print("Logging out...")
			green("\n\n\nThank you for trusting us!")
			os.Exit(0)

		case 1:
			currentUser = handleLogin(r, s)

		case 2:
			handleCreate(r, s)

		case 3:
			handleChangePassword(r, s)

		default:
			continue
		}

		if currentUser != nil {
			break
		}
		pause(r)
	}

	// ── User hub loop ──
	for {
		clearScreen()
		userHub(currentUser.Username)

		choice, err := readInt(r)
		if err != nil {
			pause(r)
			continue
		}

		switch choice {
		case 1:
			// Details
			fmt.Println("---------------------------")
			fmt.Printf(" Username      : %s\n", currentUser.Username)
			fmt.Printf(" Phone         : %s\n", currentUser.Mobile)
			fmt.Printf(" Account Type  : %s\n", currentUser.AccountType)
			fmt.Printf(" Balance       : %s\n", money(currentUser.Balance))
			fmt.Printf(" Loan          : %s\n", money(currentUser.Loan))
			fmt.Println("---------------------------")
			pause(r)

		case 2:
			cyan(fmt.Sprintf("\nCurrent balance: %s\n", money(currentUser.Balance)))
			pause(r)

		case 3:
			handleTakeLoan(r, s, currentUser)
			pause(r)

		case 4:
			handleRepayLoan(r, s, currentUser)
			pause(r)

		case 5:
			handleWithdraw(r, s, currentUser)
			pause(r)

		case 6:
			handleDeposit(r, s, currentUser)
			pause(r)

		case 7:
			handleTransfer(r, s, currentUser)
			pause(r)

		case 8:
			clearScreen()
			green("\n\n\nThank you for trusting us!")
			os.Exit(0)

		default:
			red("Invalid Input")
			pause(r)
		}
	}
}
