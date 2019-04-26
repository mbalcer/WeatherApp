package model;

public class Wind {
    private Double speed;
    private Double deg;
    private String direction;

    public Wind(Double speed, Double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Wind() {
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDeg() {
        return deg;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection() {
        if (deg>=337.5 || deg<22.5)
            this.direction = "N";
        else if (deg>=22.5 && deg<67.5)
            this.direction = "NE";
        else if (deg>=67.5 && deg<112.5)
            this.direction = "E";
        else if (deg>=112.5 && deg<157.5)
            this.direction = "SE";
        else if (deg>=157.5 && deg<202.5)
            this.direction = "S";
        else if (deg>=202.5 && deg<247.5)
            this.direction = "SW";
        else if (deg>=247.5 && deg<292.5)
            this.direction = "W";
        else if (deg>=292.5 && deg<337.5)
            this.direction = "NW";
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}
