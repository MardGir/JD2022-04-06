package by.it.avramchuk.jd02_02.entity;

public enum CashBox {
    CashBox1, CashBox2, CashBox3, CashBox4, CashBox5;
    private double totalCash=0;
    public void addSum(double sum){
        totalCash+=sum;
    }
    public double getTotalCash(){
        return totalCash;
    }
}
