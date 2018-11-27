package pong.ai;

import pong.Maila;
import pong.Pallo;
import pong.Pong;
import pong.Suunta;

public class MunPongAly implements PongAi {

    @Override
    public Suunta annaSuunta(Maila oma, Maila vastustajan, Pallo pallo) {
        // toteuta tekoälysi tänne
        
        if (oma.getTranslateY() > pallo.getTranslateY()) {
            return Suunta.YLOS;
        }
        if (oma.getTranslateY() + Pong.MAILAN_KORKEUS < pallo.getTranslateY()) {
            return Suunta.ALAS;
        }
        if (pallo.getLiike().getY() > 0) {
            return Suunta.ALAS;
        }
        if (pallo.getLiike().getY() < 0) {
            return Suunta.YLOS;
        }
        return Suunta.PAIKALLAAN;
    }

    @Override
    public String nimi() {
        return "Pelimies";
    }

}
