// Dante Stewart
// Robert Hughes

package cpsc2150.banking.models;

/**
 * @invariants homeCost >= 0  and years >= 1 and downPay >= 0
 *
 *
 * Correspondences: Customer = customer
 *                  Payment = homeCost
 */

public class Mortgage extends AbsMortgage implements IMortgage {

    public static final int months = 12;

    private final double homeCost;
    private final double downPay;
    private final int years;
    private final ICustomer customer;

    /**
     ** @param homeCost is home cost
     * @param downPay is down payment
     * @param years is length of loan
     * @param customer is client
     * @pre years >= 1 and cost >= 0 and downPay >= 0
     */

    public Mortgage(double homeCost, double downPay, int years, ICustomer customer){
        this.homeCost = homeCost;
        this.downPay = downPay;
        this.years = years;
        this.customer = customer;
    }


    @Override
    public boolean loanApproved() {
        double customerDebt =  customer.getMonthlyDebtPayments()+getPayment();
        double customerIncome =  customer.getIncome()/months;

        boolean approve1= getRate() < RATETOOHIGH;
        boolean approve2= customerDebt/customerIncome <= DTOITOOHIGH;
        boolean approve3= ( downPay/ homeCost) >= MIN_PERCENT_DOWN;

        return (approve1 && approve2 && approve3);
    }


    @Override
    public double getPayment(){
        double amount = (getRate()/months)*getPrincipal();
        double divisor = 1-Math.pow(1+getRate()/months,(-months*years));

        return (amount/divisor);
    }


    @Override
    public double getRate() {
        double baseRate = BASERATE;

        if(years < MAX_YEARS)
            baseRate+=GOODRATEADD;
        else
            baseRate+=NORMALRATEADD;


        if(PREFERRED_PERCENT_DOWN > (downPay/ homeCost) )
            baseRate+=GOODRATEADD;

        if( customer.getCreditScore() < BADCREDIT)
            baseRate+=VERYBADRATEADD;

        if( (customer.getCreditScore() >= BADCREDIT) && (customer.getCreditScore() < FAIRCREDIT))
            baseRate+=BADRATEADD;

        if( (customer.getCreditScore() >= FAIRCREDIT) && (customer.getCreditScore() < GOODCREDIT) )
            baseRate+=NORMALRATEADD;

        if( (customer.getCreditScore() < GREATCREDIT) &&  (customer.getCreditScore() >= GOODCREDIT))
            baseRate+=GOODRATEADD;

        return baseRate;
    }


    @Override
    public double getPrincipal() {
        return homeCost-downPay;
    }

    @Override
    public int getYears() {
        return years;
    }

}

