//package util;
//
//import banco.DAOGenerico;
//import modelo.Prestador;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class RetornaPrestadorLogado {
//
//    public static Prestador retornaLogado() {
//        DAOGenerico<Prestador> daoPrestador = new DAOGenerico<>(Prestador.class);
//        Object prestadorLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username;
//        if (prestadorLogado instanceof UserDetails) {
//            username = ((UserDetails) prestadorLogado).getUsername();
//        } else {
//            username = prestadorLogado.toString();
//        }
//        Prestador prestador = daoPrestador.buscarCondicao("email='" + username + "'").get(0);
//        return prestador;
//    }
//}
