package cvetkov.homework.behavioral.chain1;


import cvetkov.homework.behavioral.chain1.data.AuthCtx;
import cvetkov.homework.behavioral.chain1.data.Resource;

public class PerformLogin {
    public static void main(String[] args) {

        AuthStep authorizationStep = new AuthorizationStep(null);
        AuthStep authenticationStep = new AuthenticationStep(authorizationStep);
        AuthStep getUserStep = new GetUserStep(authenticationStep);

        AuthCtx ctx = new AuthCtx("green", "greenpwd");
        ctx.setResource(new Resource("resource"));

        getUserStep.check(ctx);

        System.out.println(ctx.isGranted());
    }
}