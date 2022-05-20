package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Plane {
        private List<String> passengers;
        private int maxPassengers;
        private Date lastTimeTookOf;
        private Date lastTimeLanded;

        public Plane(int max){
             this.maxPassengers=max;
             this.passengers=new ArrayList<>();
        }

        public void onboard(String name) {
                this.passengers.add(name);
        }

        public Date takeOff() {
                this.lastTimeTookOf = new Date();
                return lastTimeTookOf;
        }

        public void land() {
                this.lastTimeLanded = new Date();
                this.passengers.clear();
        }

        public Date getLastTimeLanded() {
                return lastTimeLanded;
        }

        public List<String> getPassengers() {
                return passengers;
        }
}
