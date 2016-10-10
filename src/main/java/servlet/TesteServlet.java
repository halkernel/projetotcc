package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class TesteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TesteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		// apagar isso ...
//		User u = new User();
//		u.setLogin(request.getParameter("login"));
//		u.setSenha(request.getParameter("senha"));
//		u.setNome(request.getParameter("nome"));
//		u.setDescricao(request.getParameter("descricao"));
//		new UserDAO().save(u);
		
		
//		List<Escola> lista = new EscolaDAO().list();
//		
//		for (Escola escola : lista) {
//			response.getWriter().write(escola.getEscolaNome()+ " - "+ escola.getMunicipio().getMunicipioNome() + "\n");	
//		}
		
		response.getWriter().write("#U*&!$(&!*!* AAAAAAAAAAAAAAAH");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
