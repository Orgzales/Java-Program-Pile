import java.security.UnrecoverableKeyException;
import java.util.Collections;

public class Student implements Comparable<Student>{

        private String S_lastname;
        private String S_firstname;
        private float S_grade;


        public Student( String lastname, String firstname, float grade)
        {
                S_lastname = lastname;
                S_firstname = firstname;
                S_grade = grade;

        }


        public String Get_lastname()
        {
                return this.S_lastname;
        }

        public String Get_firstname()
        {
                return this.S_firstname;
        }

        public float Get_grade()
        {
                return this.S_grade;
        }

        public void Set_grade(float new_gradde)
        {
                this.S_grade = new_gradde;

        }



        @Override
        public int compareTo(Student o) {
                return this.S_firstname.compareTo(o.S_firstname);
        }

        @Override
        public String toString() {
                return S_firstname + " " +  S_lastname + " - " + String.valueOf(S_grade);
        }


}
