package domain;

public enum Discount {
    CARD_DISCOUNT(1,5),
    CASH_DISCOUNT(2,3);

    private int discount;
    private int askNumber;

    private Discount(int askNumber,int discount){
        this.discount = discount;
        this.askNumber = askNumber;
    }

    public float getDiscountRate(){
        return (float)discount /100;
    }

    public boolean matchOf(int way){
        return askNumber == way;
    }

    public static Discount valueOf(int way){
        for(Discount discount : Discount.values()){
            if(discount.matchOf(way)){
                return discount;
            }
        }

        throw new IllegalArgumentException("없는 값입니다.");
    }

}
