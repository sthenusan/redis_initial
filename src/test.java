import redis.clients.jedis.Jedis;

public class test {

        private static Jedis jedis;
        private static int index = 0;

        public void setindex(int ind){
            this.index=ind;
        }

        private static Jedis database() {

            if (jedis != null)
                return jedis;

            return new Jedis("127.0.0.1", 6379);
        }

        public void addValue(String key, String value) {
            try {
                System.out.println("Connecting to REDIS to add new key-val pair ");
                database().select(index);
                database().set(key, value);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void getValue(String key){
            try {
                System.out.println("Connecting to REDIS to get value for a key ");
                database().select(index);
                String val= database().get(key);
                System.out.println(val);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void removeValue(String keyToDel) {
            database().del(keyToDel);
        }

        public void closeDatabase() {
            database().close();
        }

    public static void main(String ars[]){
        System.out.println(database().ping());
        test ch= new test();
        ch.setindex(3);
        ch.addValue("thenu","checking");
        ch.getValue("thenu");
    }
}

