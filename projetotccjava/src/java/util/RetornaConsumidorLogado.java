//package util;
//
//import banco.DAOGenerico;
//import modelo.Consumidor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class RetornaConsumidorLogado {
//
//    public static Consumidor retornaLogado() {
//        DAOGenerico<Consumidor> daoConsumidor = new DAOGenerico<>(Consumidor.class);
//        Object consumidorLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username;
//        if (consumidorLogado instanceof UserDetails) {
//            username = ((UserDetails) consumidorLogado).getUsername();
//        } else {
//            username = consumidorLogado.toString();
//        }
//        Consumidor consumidor = daoConsumidor.buscarCondicao("email='" + username + "'").get(0);
//        return consumidor;
//    }
//}
