package sprint5.coki;

public class FortuneCookieController {
    private final FortuneCookieFactory fortuneCookieFactory;

    public FortuneCookieController (FortuneCookieFactory fortuneCookieFactory) {
        this.fortuneCookieFactory = fortuneCookieFactory;
    }

    public FortuneCookie tellFortune() {
        return this.fortuneCookieFactory.bakeFortuneCookie();
    }
}
