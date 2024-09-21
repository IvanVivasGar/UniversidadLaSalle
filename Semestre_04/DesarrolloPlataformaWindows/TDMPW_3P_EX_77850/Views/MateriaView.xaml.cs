namespace TDMPW_3P_EX_77850.Views;

public partial class MateriaView : ContentPage
{
	public MateriaView()
	{
		InitializeComponent();
	}

	private void ClikedNombreMateria(object sender, EventArgs e)
	{
		this.entryNombreMateria.IsVisible = false;
		this.btnNombreMateria.IsVisible = false;
		this.lblNombreMateria.IsVisible = true;
		btnCalificacionFinal.IsVisible = !btnNombreMateria.IsVisible && !btnNombreRubros.IsVisible && !btnValoresRubros.IsVisible && !btnCalificacionRubros.IsVisible;
	}

	private void ClickedNombreRubros(object sender, EventArgs e)
	{
		this.entryNombreRubros.IsVisible = false;
		this.btnNombreRubros.IsVisible = false;
		this.lblNombreRubros.IsVisible = true;
		btnCalificacionFinal.IsVisible = !btnNombreMateria.IsVisible && !btnNombreRubros.IsVisible && !btnValoresRubros.IsVisible && !btnCalificacionRubros.IsVisible;
	}

	private void ClikedValoresRubros(object sender, EventArgs e)
	{
		this.entryValoresRubros.IsVisible = false;
		this.btnValoresRubros.IsVisible = false;
		this.lblValoresRubros.IsVisible = true;
		btnCalificacionFinal.IsVisible = !btnNombreMateria.IsVisible && !btnNombreRubros.IsVisible && !btnValoresRubros.IsVisible && !btnCalificacionRubros.IsVisible;
	}

	private void ClikedCalificacionesRubros(object sender, EventArgs e)
	{
		this.entryNuevasCalificaciones.IsVisible = false;
		this.btnCalificacionRubros.IsVisible = false;
		this.lblCalificacionRubros.IsVisible = true;
		btnCalificacionFinal.IsVisible = !btnNombreMateria.IsVisible && !btnNombreRubros.IsVisible && !btnValoresRubros.IsVisible && !btnCalificacionRubros.IsVisible;
	}

	private float[] stringfloat(String cadenaDeNumeros)
	{
		string[] partes = cadenaDeNumeros.Split(',');

		float[] arregloNumeros = new float[partes.Length];
		for (int i = 0; i < partes.Length; i++)
		{
			arregloNumeros[i] = float.Parse(partes[i]);
		}

		return arregloNumeros;
	}

	private float calcularEquivalencia(float porcentaje, float calificacion){
		float resultado = calificacion * porcentaje / 10;
		return resultado;
	}

	private void ClickedCalcularCalificacionFinal(object sender, EventArgs e)
	{
		float[] valoresRubros = stringfloat(this.lblValoresRubros.Text);
		float[] calificacionRubros = stringfloat(this.lblCalificacionRubros.Text);
		float calificacionFinal = 0;

		if(valoresRubros.Sum() == 100 && calificacionRubros.All(x => x >= 0 && x <= 10)){
			for(int i = 0; i < valoresRubros.Length; i++){
				calificacionFinal += calcularEquivalencia(valoresRubros[i], calificacionRubros[i]);
			}
			this.lblCalificacionFinal.Text = calificacionFinal.ToString();
		}else{
			this.lblCalificacionFinal.Text = "Hay un error en el valor de los rubros o las calificaciones, revisa e intenta de nuevo";
		}
		btnCalificacionFinal.IsVisible = false;
		btnReiniciarCalificacionFinal.IsVisible = true;
	}

	private void ClickedReiniciarCalcularCalificacionFinal(object sender, EventArgs e)
	{
		this.entryNombreMateria.IsVisible = true;
		entryNombreMateria.Text = "";
		this.btnNombreMateria.IsVisible = true;
		this.lblNombreMateria.IsVisible = false;

		this.entryNombreRubros.IsVisible = true;
		entryNombreRubros.Text = "";
		this.btnNombreRubros.IsVisible = true;
		this.lblNombreRubros.IsVisible = false;

		this.entryValoresRubros.IsVisible = true;
		entryValoresRubros.Text = "";
		this.btnValoresRubros.IsVisible = true;
		this.lblValoresRubros.IsVisible = false;

		this.entryNuevasCalificaciones.IsVisible = true;
		entryNuevasCalificaciones.Text = "";
		this.btnCalificacionRubros.IsVisible = true;
		this.lblCalificacionRubros.IsVisible = false;

		btnCalificacionFinal.IsVisible = true;
		btnReiniciarCalificacionFinal.IsVisible = false;
	}
}