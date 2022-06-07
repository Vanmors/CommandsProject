package com.company.data;

import java.io.Serializable;

public class Coordinates implements Serializable {
        private Integer x; //Максимальное значение поля: 676, Поле не может быть null
        private Long y; //Поле не может быть null

        /**
         * координаты
         * @param x координата по x
         * @param y координата по y
         */
        public Coordinates(Integer x, Long y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }
        public Long getY() {
            return y;
        }
}
