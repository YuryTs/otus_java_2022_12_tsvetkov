package cvetkov.homework.behavioral.chain1;

import cvetkov.homework.behavioral.chain1.data.AuthCtx;
import cvetkov.homework.behavioral.chain1.data.Realm;
import cvetkov.homework.behavioral.chain1.data.User;

public class AuthorizationStep extends AuthStep {
    public AuthorizationStep(final AuthStep next) {
        super(next);
    }

    @Override
    public void check(AuthCtx ctx) {
        System.out.println("---------> Authorisation");
        User user = ctx.getUser();
        Realm realm = user.getRealm();
        if (realm.checkResource(ctx.getResource())) {
            ctx.setGranted(true);
            next(ctx);
        }
    }
}