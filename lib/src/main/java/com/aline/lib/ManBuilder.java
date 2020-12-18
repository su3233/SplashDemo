package com.aline.lib;

/**
 * Builder模式
 *
 * @author SuTs
 * @create 2020/10/30 16:53
 * @Describe
 */
public class ManBuilder {
    private String name;
    private int age;
    private int carNo;
    private boolean isMarried;//是否结婚

    public static class Builder {
        private String name;
        private int age;
        private int carNo;
        private boolean isMarried;//是否结婚

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setCarNo(int carno) {
            carNo = carno;
            return this;
        }

        public Builder setMarried(boolean married) {
            isMarried = married;
            return this;
        }

        public ManBuilder build() {
            ManBuilder manBuilder = new ManBuilder();
            manBuilder.setName(name);
            manBuilder.setAge(age);
            manBuilder.setMarried(isMarried);
            return manBuilder;
        }
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carNo=" + carNo +
                ", isMarried=" + isMarried +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCarNo() {
        return carNo;
    }

    public void setCarNo(int carNo) {
        this.carNo = carNo;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }
}
