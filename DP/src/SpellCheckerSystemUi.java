import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SpellCheckerSystemUi extends JFrame implements ActionListener {

    // Predefined Dictionary
    static ArrayList<String> dictionary = new ArrayList<>();

    // User Dictionary
    static ArrayList<String> userDictionary = new ArrayList<>();

    // GUI Components
    JLabel titleLabel;
    JLabel inputLabel;
    JLabel dictionaryLabel;
    JLabel userDictionaryLabel;
    JLabel correctedLabel;

    JTextArea inputArea;
    JTextArea correctedArea;
    JTextArea userWordArea;
    JTextArea dictionaryArea;

    JScrollPane inputScroll;
    JScrollPane correctedScroll;
    JScrollPane tableScroll;
    JScrollPane userWordScroll;
    JScrollPane dictionaryScroll;

    JButton checkButton;
    JButton addWordButton;
    JButton clearButton;

    JTable resultTable;

    DefaultTableModel tableModel;

    JComboBox<String> dictionaryChoice;

    // Constructor
    public SpellCheckerSystemUi() {

        // Load predefined dictionary
        loadDictionary();

        // Frame Settings
        setTitle("Spell Checker System");
        setSize(1000, 720);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Title
        titleLabel = new JLabel("SPELL CHECKER SYSTEM");

        titleLabel.setBounds(280, 10, 500, 40);

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 30));

        add(titleLabel);

        // Dictionary Choice
        String[] choices = {
                "Use Predefined Dictionary",
                "Use User Dictionary",
                "Use Both Dictionaries"
        };

        dictionaryChoice =
                new JComboBox<>(choices);

        dictionaryChoice.setBounds(30, 70, 280, 35);

        dictionaryChoice.setFont(
                new Font("Arial", Font.PLAIN, 15));

        add(dictionaryChoice);

        // Update Dictionary on Selection Change
        dictionaryChoice.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(
                            ActionEvent e) {

                        // Clear User Dictionary
                        // when selecting
                        // User Dictionary Mode

                        if (dictionaryChoice
                                .getSelectedIndex() == 1) {

                            userDictionary.clear();
                        }

                        updateDictionaryArea();
                    }
                });

        // Input Label
        inputLabel =
                new JLabel("Enter Sentence:");

        inputLabel.setBounds(30, 130, 250, 30);

        inputLabel.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(inputLabel);

        // Input Area
        inputArea =
                new JTextArea();

        inputArea.setFont(
                new Font("Monospaced", Font.PLAIN, 16));

        inputScroll =
                new JScrollPane(inputArea);

        inputScroll.setBounds(30, 170, 420, 100);

        add(inputScroll);

        // Dictionary Label
        dictionaryLabel =
                new JLabel("Dictionary Words:");

        dictionaryLabel.setBounds(500, 70, 250, 30);

        dictionaryLabel.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(dictionaryLabel);

        // Dictionary Area
        dictionaryArea =
                new JTextArea();

        dictionaryArea.setEditable(false);

        dictionaryArea.setLineWrap(true);

        dictionaryArea.setWrapStyleWord(true);

        dictionaryArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14));

        updateDictionaryArea();

        dictionaryScroll =
                new JScrollPane(dictionaryArea);

        dictionaryScroll.setBounds(500, 110, 430, 160);

        add(dictionaryScroll);

        // User Dictionary Label
        userDictionaryLabel =
                new JLabel("Add User Dictionary Word:");

        userDictionaryLabel.setBounds(30, 300, 300, 30);

        userDictionaryLabel.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(userDictionaryLabel);

        // User Word Area
        userWordArea =
                new JTextArea();

        userWordArea.setFont(
                new Font("Monospaced", Font.PLAIN, 16));

        userWordScroll =
                new JScrollPane(userWordArea);

        userWordScroll.setBounds(30, 340, 250, 50);

        add(userWordScroll);

        // Add Word Button
        addWordButton =
                new JButton("Add Word");

        addWordButton.setBounds(300, 340, 150, 50);

        addWordButton.setFont(
                new Font("Arial", Font.BOLD, 15));

        addWordButton.addActionListener(this);

        add(addWordButton);

        // Check Button
        checkButton =
                new JButton("Check Spelling");

        checkButton.setBounds(500, 320, 180, 45);

        checkButton.setFont(
                new Font("Arial", Font.BOLD, 15));

        checkButton.addActionListener(this);

        add(checkButton);

        // Clear Button
        clearButton =
                new JButton("Clear");

        clearButton.setBounds(720, 320, 150, 45);

        clearButton.setFont(
                new Font("Arial", Font.BOLD, 15));

        clearButton.addActionListener(this);

        add(clearButton);

        // Table Columns
        String[] columns = {
                "No.",
                "Entered Word",
                "Status",
                "Suggestion"
        };

        // Table Model
        tableModel =
                new DefaultTableModel(columns, 0);

        // Result Table
        resultTable =
                new JTable(tableModel);

        resultTable.setRowHeight(28);

        resultTable.setFont(
                new Font("Arial", Font.PLAIN, 14));

        resultTable.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 15));

        tableScroll =
                new JScrollPane(resultTable);

        tableScroll.setBounds(30, 430, 900, 160);

        add(tableScroll);

        // Corrected Sentence Label
        correctedLabel =
                new JLabel("Corrected Sentence:");

        correctedLabel.setBounds(30, 610, 250, 30);

        correctedLabel.setFont(
                new Font("Arial", Font.BOLD, 18));

        add(correctedLabel);

        // Corrected Area
        correctedArea =
                new JTextArea();

        correctedArea.setEditable(false);

        correctedArea.setFont(
                new Font("Monospaced", Font.PLAIN, 16));

        correctedScroll =
                new JScrollPane(correctedArea);

        correctedScroll.setBounds(260, 605, 670, 50);

        add(correctedScroll);

        // Show Frame
        setVisible(true);
    }

    // Button Events
    @Override
    public void actionPerformed(ActionEvent e) {

        // Add User Word
        if (e.getSource() == addWordButton) {

            String word =
                    userWordArea.getText()
                            .trim()
                            .toLowerCase();

            // Empty Check
            if (word.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Empty word not allowed.");

                return;
            }

            int choice =
                    dictionaryChoice.getSelectedIndex();

            // Predefined Dictionary Mode
            if (choice == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Cannot add words in Predefined Dictionary Mode.");

                return;
            }

            // Duplicate Check
            if (!userDictionary.contains(word)) {

                userDictionary.add(word);

                JOptionPane.showMessageDialog(
                        this,
                        word + " added successfully.");

                userWordArea.setText("");

                updateDictionaryArea();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Word already exists.");
            }
        }

        // Check Spelling
        if (e.getSource() == checkButton) {

            // Clear Old Data
            tableModel.setRowCount(0);

            correctedArea.setText("");

            String input =
                    inputArea.getText();

            // Empty Input Check
            if (input.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter a sentence.");

                return;
            }

            // Split Sentence
            String[] words =
                    input.split(" ");

            String correctedSentence = "";

            int serial = 1;

            // Check Each Word
            for (String word : words) {

                // Remove Special Characters
                String cleanWord =
                        word.replaceAll("[^a-zA-Z]", "")
                                .toLowerCase();

                // Skip Empty
                if (cleanWord.isEmpty()) {
                    continue;
                }

                // Correct Word
                if (isCorrect(cleanWord)) {

                    tableModel.addRow(
                            new Object[]{
                                    serial,
                                    word,
                                    "Correct",
                                    "-"
                            });

                    correctedSentence += cleanWord + " ";
                }

                // Incorrect Word
                else {

                    String suggestion =
                            suggestWord(cleanWord);

                    tableModel.addRow(
                            new Object[]{
                                    serial,
                                    word,
                                    "Incorrect",
                                    suggestion
                            });

                    correctedSentence += suggestion + " ";
                }

                serial++;
            }

            correctedArea.setText(correctedSentence);
        }

        // Clear Button
        if (e.getSource() == clearButton) {

            inputArea.setText("");

            correctedArea.setText("");

            userWordArea.setText("");

            tableModel.setRowCount(0);
        }
    }

    // Update Dictionary Display
    public void updateDictionaryArea() {

        dictionaryArea.setText("");

        int choice =
                dictionaryChoice.getSelectedIndex();

        String words = "";

        // Predefined Dictionary
        if (choice == 0 || choice == 2) {

            for (String word : dictionary) {

                words += word + " | ";
            }
        }

        // User Dictionary
        if (choice == 1 || choice == 2) {

            for (String word : userDictionary) {

                words += word + " | ";
            }
        }

        dictionaryArea.setText(words);
    }

    // Load Dictionary
    public static void loadDictionary() {

        dictionary.add("java");
        dictionary.add("computer");
        dictionary.add("science");
        dictionary.add("project");
        dictionary.add("network");
        dictionary.add("system");
        dictionary.add("software");
        dictionary.add("hardware");
        dictionary.add("database");
        dictionary.add("checker");
        dictionary.add("keyboard");
        dictionary.add("mouse");
        dictionary.add("internet");
        dictionary.add("student");
        dictionary.add("college");
        dictionary.add("screen");
        dictionary.add("program");
        dictionary.add("hello");
        dictionary.add("world");
        dictionary.add("spell");
    }

    // Check Correct Word
    public boolean isCorrect(String word) {

        int choice =
                dictionaryChoice.getSelectedIndex();

        // Predefined Dictionary
        if (choice == 0 || choice == 2) {

            for (String dictWord : dictionary) {

                if (word.equalsIgnoreCase(dictWord)) {

                    return true;
                }
            }
        }

        // User Dictionary
        if (choice == 1 || choice == 2) {

            for (String userWord : userDictionary) {

                if (word.equalsIgnoreCase(userWord)) {

                    return true;
                }
            }
        }

        return false;
    }

    // Suggest Closest Word
    public String suggestWord(String inputWord) {

        int maxMatch = -1;

        String bestWord = "No Suggestion";

        int choice =
                dictionaryChoice.getSelectedIndex();

        // Predefined Dictionary
        if (choice == 0 || choice == 2) {

            for (String dictWord : dictionary) {

                int match =
                        countMatchingCharacters(
                                inputWord,
                                dictWord);

                if (match > maxMatch) {

                    maxMatch = match;
                    bestWord = dictWord;
                }
            }
        }

        // User Dictionary
        if (choice == 1 || choice == 2) {

            for (String userWord : userDictionary) {

                int match =
                        countMatchingCharacters(
                                inputWord,
                                userWord);

                if (match > maxMatch) {

                    maxMatch = match;
                    bestWord = userWord;
                }
            }
        }

        return bestWord;
    }

    // Matching Logic
    public int countMatchingCharacters(
            String s1,
            String s2) {

        int count = 0;

        for (int i = 0; i < s1.length(); i++) {

            char ch = s1.charAt(i);

            if (s2.indexOf(ch) != -1) {

                count++;
            }
        }

        return count;
    }

    // Main Method
    public static void main(String[] args) {

        new SpellCheckerSystemUi();
    }
}