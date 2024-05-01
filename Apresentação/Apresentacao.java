public class Apresentacao {
        public static void main(String[] args) {
          Me Victor  = new Me();
          victor.sayHello();
        }
      }

      class Me {
        public String name = "Victor Raphael";
        public String age = "18";
        public String tech = "HTML, CSS, JavaScript, Java, Python,";
        public String extra = "SQL, PHP, Dashbords";
        private String secret = "Nothing Here...";

        public void sayHello() {
          System.out.println("Welcome to my profile!");
        }
      }