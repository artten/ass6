/**
 * @author 319339198
 */
/**
 * counter.
 */
public class Counter {
    private int number = 0;

    /**
     * add number to current count.
     * @param num - add to this number
     */
    void increase(int num) {
        this.number = this.number + num;
    }

    /**
     *  subtract number from current count.
     * @param num - subtract from this number
     */
    void decrease(int num) {
        this.number = this.number - num;
    }

    /**
     *  get current count.
     * @return number
     */
    int getValue() {
        return this.number;
    }
}