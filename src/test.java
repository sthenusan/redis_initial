import redis.clients.jedis.Jedis;

public class test {

        private static Jedis jedis;

        private static Jedis database() {

            if (jedis != null)
                return jedis;

            return new Jedis("127.0.0.1", 6379);
        }

        public void addValue(int index,String key, String value) {
            try {
                System.out.println("Connecting to JEDIS ... ");
                database().select(index);
                database().set(key, value);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void getValue(int index, String key){
            try {
                System.out.println("Connecting to JEDIS ... ");
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
        ch.addValue(2,"thenusan","checking_entry");
        ch.getValue(2,"thenusan");
    }
}

