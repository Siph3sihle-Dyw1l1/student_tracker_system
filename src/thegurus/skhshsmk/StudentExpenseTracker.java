package thegurus.skhshsmk;

import java.io.Serializable;

public class StudentExpenseTracker implements Serializable {

    private String studentNo;
    private double monthlyAllowance;
    private String firstExpense;
    private String secondExpense;
    private String thirdExpense;
    private double amountForExpense1;
    private double amountForExpense2;
    private double amountForExpense3;

    public StudentExpenseTracker() {
        studentNo = "";
        monthlyAllowance = 0.0;
        firstExpense = "";
        secondExpense = "";
        thirdExpense = "";
        amountForExpense1 = 0.0;
        amountForExpense2 = 0.0;
        amountForExpense3 = 0.0;
    }

    public StudentExpenseTracker(String studentNo, double monthlyAllowance, String firstExpense, String secondExpense, String thirdExpense, double amountForExpense1, double amountForExpense2, double amountForExpense3) {
        this.studentNo = studentNo;
        this.monthlyAllowance = monthlyAllowance;
        this.firstExpense = firstExpense;
        this.secondExpense = secondExpense;
        this.thirdExpense = thirdExpense;
        this.amountForExpense1 = amountForExpense1;
        this.amountForExpense2 = amountForExpense2;
        this.amountForExpense3 = amountForExpense3;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public double getMonthlyAllowance() {

        return monthlyAllowance;
    }

    public void setMonthlyAllowance(double monthlyAllowance) {
        if (monthlyAllowance >= 0) {
            this.monthlyAllowance = monthlyAllowance;
        }
    }

    public String getFirstExpense() {
        return firstExpense;
    }

    public void setFirstExpense(String firstExpense) {
        this.firstExpense = firstExpense;
    }

    public String getSecondExpense() {
        return secondExpense;
    }

    public void setSecondExpense(String secondExpense) {
        this.secondExpense = secondExpense;
    }

    public String getThirdExpense() {
        return thirdExpense;
    }

    public void setThirdExpense(String thirdExpense) {
        this.thirdExpense = thirdExpense;
    }

    public double getAmountForExpense1() {
        return amountForExpense1;
    }

    public void setAmountForExpense1(double amountForExpense1) {
        if (amountForExpense1 >= 0) {
            this.amountForExpense1 = amountForExpense1;
        }
    }

    public double getAmountForExpense2() {
        return amountForExpense2;
    }

    public void setAmountForExpense2(double amountForExpense2) {
        if (amountForExpense2 >= 0) {
            this.amountForExpense2 = amountForExpense2;
        }
    }

    public double getAmountForExpense3() {
        return amountForExpense3;
    }

    public void setAmountForExpense3(double amountForExpense3) {
        if (amountForExpense3 >= 0) {
            this.amountForExpense3 = amountForExpense3;
        }
    }

    public double calculateTotal() {

        return amountForExpense1 + amountForExpense2 + amountForExpense3;
    }

    @Override
    public String toString() {
        return studentNo + "-" + monthlyAllowance + "-" + firstExpense + "-" + secondExpense
                + "-" + thirdExpense + "-" + amountForExpense1 + "-" + amountForExpense2
                + "-" + amountForExpense3 + "-" + calculateTotal();
    }

}
