package API.POJO;

public class Reqres {


        String name;
        String job;
        public Reqres(String name, String job){
            this.name=name;
            this.job=job;
        }

//        {
//            "name": "morpheus",
//                "job": "zion resident"
//        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName(){
            return name;

        }
        public void setName(String name){
            this.name=name;
        }
        public static void main(String[]args){

        }
        @Override
        public String toString(){
            return "This is the name of object "+this.name+" This is the job of the object "+this.job;
        }




    }