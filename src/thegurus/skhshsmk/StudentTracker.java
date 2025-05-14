package thegurus.skhshsmk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class StudentTracker extends javax.swing.JFrame {

    ArrayList<StudentExpenseTracker> expense;

    public StudentTracker() {
        initComponents();
        
        this.setResizable(false);
        this.setSize(1003, 683);
        
        // Optional: Center the window on screen
        this.setLocationRelativeTo(null);
        
        expense = new ArrayList<>();
        populateArrayList();
        displayHistory();

        studentNum.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                }

            }
        });

    }

    //method for getting data from files
    public void populateArrayList() {

        try {

            FileReader file = new FileReader("ExpenseList.txt");
            BufferedReader inputFile = new BufferedReader(file);

            String line;

            while ((line = inputFile.readLine()) != null) {
                try {
                    String[] prt = line.split("-");

                    if (prt.length == 9) {
                        String studentNumber = prt[0];
                        double monthlyAllowance = Double.parseDouble(prt[1]);
                        String firstExpense = prt[2];
                        String secondExpense = prt[3];
                        String thirdExpense = prt[4];
                        double amountExp1 = Double.parseDouble(prt[5]);
                        double amountExp2 = Double.parseDouble(prt[6]);
                        double amountExp3 = Double.parseDouble(prt[7]);

                        StudentExpenseTracker ex = new StudentExpenseTracker(studentNumber, monthlyAllowance, firstExpense, secondExpense, thirdExpense, amountExp1, amountExp2, amountExp3);

                        expense.add(ex);
                    } else {
                        JOptionPane.showMessageDialog(null, "Line format is incorrect: " + line);
                    }

                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }

            inputFile.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //method for saving the students data to our file
    public void saveStudentExpensesToFile() {

        try {

            FileWriter file = new FileWriter("ExpenseList.txt");
            BufferedWriter outPutFile = new BufferedWriter(file);

            for (StudentExpenseTracker ex : expense) {

                outPutFile.write(ex.toString());
                outPutFile.newLine();

            }

            outPutFile.close();

            JOptionPane.showMessageDialog(null, "Expenses successfully saved");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //method for clearing the fields
    public void clearFields() {
        firstExpense.setText(null);
        secondExpense.setText(null);
        thirdExpense.setText(null);
        jTextArea1.setText(null);
        amountExp1.setText(null);
        amountExp2.setText(null);
        amountExp3.setText(null);
        studentNum.setText(null);
        monthlyAlwance.setText(null);

    }

    //method for displaying or reading text from the file
    // Method to display history in the text area as a table
    public void displayHistory() {
        DecimalFormat df = new DecimalFormat("R#######.##");
        StringBuilder history = new StringBuilder();

        // Add table header
        history.append("EXPENSE HISTORY FOR ALL STUDENTS\n\n");
        history.append("Student No.\tAllowance\tExpense 1\tAmount\tExpense 2\tAmount\tExpense 3\tAmount\tTotal\n");
        history.append("------------------------------------------------------------------------------------------------"
                + "-----------------------------------------------------------------------------\n");

        for (StudentExpenseTracker ex : expense) {
            history.append(ex.getStudentNo()).append("\t")
                    .append(df.format(ex.getMonthlyAllowance())).append("\t")
                    .append(ex.getFirstExpense()).append("\t")
                    .append(df.format(ex.getAmountForExpense1())).append("\t")
                    .append(ex.getSecondExpense()).append("\t")
                    .append(df.format(ex.getAmountForExpense2())).append("\t")
                    .append(ex.getThirdExpense()).append("\t")
                    .append(df.format(ex.getAmountForExpense3())).append("\t")
                    .append(df.format(ex.calculateTotal())).append("\n");
        }

        jTextArea1.setText(history.toString());
    }

    //method for displaying a summary for only one person
    public void display() {
        DecimalFormat df = new DecimalFormat("R#######.##");

        try {
            String studNum = studentNum.getText().trim();
            String fExpense = firstExpense.getText().trim();
            String sExpense = secondExpense.getText().trim();
            String tExpense = thirdExpense.getText().trim();
            double fAmount = Double.parseDouble(amountExp1.getText().trim());
            double sAmount = Double.parseDouble(amountExp2.getText().trim());
            double tAmount = Double.parseDouble(amountExp3.getText().trim());
            double monthAmount = Double.parseDouble(monthlyAlwance.getText().trim());

            StudentExpenseTracker expens = new StudentExpenseTracker(studNum, monthAmount, fExpense, sExpense, tExpense, fAmount, sAmount, tAmount);
            //getting the total and the remmaining balance
            double total = expens.calculateTotal();
            double currentBalance = monthAmount - total;
            //displaying on the text Area
            jTextArea1.setText("\n\tSummary Of " + studNum + " Expenses\n"
                    + "\n=============================================="
                    + "\nMonthly Budget: " + df.format(monthAmount)
                    + "\nFirst expense:  " + fExpense + ", cost " + df.format(fAmount)
                    + "\nSecond expense: " + sExpense + ", cost " + df.format(sAmount)
                    + "\nThird expense:  " + tExpense + ", cost " + df.format(tAmount)
                    + "\nTotal Amount:" + df.format(total)
                    + "\n==============================================="
                    + "\nCurrent Balance: " + df.format(currentBalance)
                    + "\n===============================================");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for the amounts!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        firstExpense = new javax.swing.JTextField();
        secondExpense = new javax.swing.JTextField();
        thirdExpense = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        amountExp1 = new javax.swing.JTextField();
        amountExp2 = new javax.swing.JTextField();
        amountExp3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        studentNum = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        monthlyAlwance = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        displaySummaryButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        jLabel13.setText("jLabel13");

        jLabel15.setText("jLabel15");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To The Student Expense Tracker System");

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setText("WELCOME TO THE STUDENT EXPENSE TRACKER SYSTEM");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Enter Student's Expenses Below:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 51));
        jLabel3.setText("Types of Expenses:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("Amount Cost:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Enter your first expense:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Enter your second expense:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Enter your third expense:");

        firstExpense.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstExpense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstExpenseActionPerformed(evt);
            }
        });

        secondExpense.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        thirdExpense.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 153));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("R");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("R");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("R");

        amountExp1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amountExp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountExp1ActionPerformed(evt);
            }
        });

        amountExp2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amountExp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountExp2ActionPerformed(evt);
            }
        });

        amountExp3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        amountExp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountExp3ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Enter Student Number:");

        studentNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        studentNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNumActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Enter monthly allowance: ");

        monthlyAlwance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        monthlyAlwance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyAlwanceActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(255, 193, 7));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thegurus/skhshsmk/resized_clear.png"))); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(40, 167, 69));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thegurus/skhshsmk/icons8-save-button-48.png"))); // NOI18N
        saveButton.setText("SAVE");
        saveButton.setBorderPainted(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        displaySummaryButton.setBackground(new java.awt.Color(211, 211, 211));
        displaySummaryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thegurus/skhshsmk/resized_display.png"))); // NOI18N
        displaySummaryButton.setText("DISPLAY SUMMARY");
        displaySummaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displaySummaryButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(220, 53, 69));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thegurus/skhshsmk/resized_exit.png"))); // NOI18N
        exitButton.setText("EXIT SYSTEM");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("R");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(clearButton)
                                .addGap(112, 112, 112)
                                .addComponent(saveButton)
                                .addGap(158, 158, 158)
                                .addComponent(displaySummaryButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(firstExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(thirdExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(secondExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(amountExp1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amountExp3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amountExp2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(612, 612, 612)
                                .addComponent(jLabel4)))
                        .addGap(89, 89, 89)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(monthlyAlwance, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(studentNum))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(204, 204, 204)))
                        .addGap(351, 351, 351))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNum, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(monthlyAlwance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountExp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(firstExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secondExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(amountExp2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(thirdExpense, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(amountExp3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displaySummaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstExpenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstExpenseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstExpenseActionPerformed

    private void amountExp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountExp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountExp2ActionPerformed

    private void amountExp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountExp3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountExp3ActionPerformed

    private void amountExp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountExp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountExp1ActionPerformed

    private void displaySummaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displaySummaryButtonActionPerformed
        // TODO add your handling code here:
        display();

    }//GEN-LAST:event_displaySummaryButtonActionPerformed

    private void monthlyAlwanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyAlwanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthlyAlwanceActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

        clearFields();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here
        if (firstExpense.getText().isEmpty() || secondExpense.getText().isEmpty() || thirdExpense.getText().isEmpty()
                || amountExp1.getText().isEmpty() || amountExp2.getText().isEmpty() || amountExp3.getText().isEmpty()
                || studentNum.getText().isEmpty() || monthlyAlwance.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter all fields!!");

        } else {
            try {

                String studNum = studentNum.getText().trim();
                String fExpense = firstExpense.getText().trim();
                String sExpense = secondExpense.getText().trim();
                String tExpense = thirdExpense.getText().trim();

                double fAmount = Double.parseDouble(amountExp1.getText().trim());
                double sAmount = Double.parseDouble(amountExp2.getText().trim());
                double tAmount = Double.parseDouble(amountExp3.getText().trim());
                double monthAmount = Double.parseDouble(monthlyAlwance.getText().trim());

                StudentExpenseTracker expens = new StudentExpenseTracker(studNum, monthAmount, fExpense, sExpense, tExpense, fAmount, sAmount, tAmount);

                if (expens.calculateTotal() > expens.getMonthlyAllowance()) {
                    JOptionPane.showMessageDialog(null, "Your expenses have exceeded your budget for this month. Please reduce your expenses accordingly.", tExpense, HEIGHT);

                } else {
                    expense.add(expens);

                    // Save to file
                    saveStudentExpensesToFile();

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for the amounts!", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void studentNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNumActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentTracker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountExp1;
    private javax.swing.JTextField amountExp2;
    private javax.swing.JTextField amountExp3;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton displaySummaryButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField firstExpense;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField monthlyAlwance;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField secondExpense;
    private javax.swing.JTextField studentNum;
    private javax.swing.JTextField thirdExpense;
    // End of variables declaration//GEN-END:variables

}
