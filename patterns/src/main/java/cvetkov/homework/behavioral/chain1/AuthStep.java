package cvetkov.homework.behavioral.chain1;

import cvetkov.homework.behavioral.chain1.data.AuthCtx;

public abstract class AuthStep {

    private final AuthStep next;

    public AuthStep(final AuthStep next) {
        this.next = next;
    }

    public abstract void check(AuthCtx ctx); //как у Command выполнение действия

    public final void next(AuthCtx ctx) { //перейти на следующий шаг
        if (next != null) {
            next.check(ctx);
        }
    }
}