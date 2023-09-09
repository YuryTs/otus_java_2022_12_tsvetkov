package cvetkov.homework.behavioral.chain1;


import cvetkov.homework.behavioral.chain1.data.AuthCtx;
import cvetkov.homework.behavioral.chain1.data.User;
import cvetkov.homework.behavioral.chain1.data.UserStorage;

public class GetUserStep extends AuthStep {

    public GetUserStep(final AuthStep next) {
        super(next);
    }

    @Override
    public void check(AuthCtx ctx) {
        System.out.println("---------> Looking for user");
        User user = UserStorage.getUser(ctx.getUserName()); //получает из контекста узера
        if (user != null) {
            ctx.setUser(user); // если такой юзер есть то он устанавливает в контекст этого юзера
            next(ctx); //и передает следующему
        }
    }
}