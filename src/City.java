import java.util.List;

public class City {
    private String name;
    private List<District> districts;

    public City(String name, List<District> districts) {
        this.name = name;
        this.districts = districts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistrict(List<District> districts) {
        this.districts = districts;
    }

    static class District {
        private String name;
        private List<String> streets;

        public District(String name, List<String> streets) {
            this.name = name;
            this.streets = streets;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getStreets() {
            return streets;
        }

        public void setStreets(List<String> streets) {
            this.streets = streets;
        }
    }
}
