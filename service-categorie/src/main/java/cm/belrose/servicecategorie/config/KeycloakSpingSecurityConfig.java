package cm.belrose.servicecategorie.config;


public class KeycloakSpingSecurityConfig{}
/*
public class KeycloakSpingSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    */
/**
     * Cette methode de Spring specifie ou Spring security trouvera les utilisateurs et leurs  roles
     * dans ce cas de figure, c'est keycloak qui est spécifié
     * @param auth
     * @throws Exception
     *//*

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        //spécifie que l'accès à cette ressource demande a s'authentifier uniquement
        //http.authorizeRequests().antMatchers("/categories/**").authenticated();
        //spécifie que l'accès à cette ressource demande a s'authentifier en tant que app-manager
       // http.authorizeRequests().antMatchers("/categories/**").hasAnyAuthority("app-manager");
    }
}
*/
