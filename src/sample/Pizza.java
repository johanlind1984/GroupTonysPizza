

public class Pizza {

        private String namn;
        private double price;
        private int ordernumber;
        //default constructor
        public Pizza() {
        }


        public Pizza(String namn, double price, int ordernumber) {
            this.namn = namn;
            this.price = price;
            this.ordernumber = ordernumber;
        }


        /**
         * Get the value of ordernumber
         *
         * @return the value of ordernumber
         */
        public int getOrdernumber() {
            return ordernumber;
        }

        /**
         * Set the value of ordernumber
         *
         * @param ordernumber new value of ordernumber
         */
        public void setOrdernumber(int ordernumber) {
            this.ordernumber = ordernumber;
        }


        /**
         * Get the value of price
         *
         * @return the value of price
         */
        public double getPrice() {
            return price;
        }

        /**
         * Set the value of price
         *
         * @param price new value of price
         */
        public void setPrice(double price) {
            this.price = price;
        }


        /**
         * Get the value of namn
         *
         * @return the value of namn
         */
        public String getNamn() {
            return namn;
        }

        /**
         * Set the value of namn
         *
         * @param namn new value of namn
         */
        public void setNamn(String namn) {
            this.namn = namn;
        }
    }
