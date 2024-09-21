namespace TDMPW_3P_EX_77850.Views;

public partial class SemestreView : ContentPage
{
	public SemestreView()
	{
		InitializeComponent();
	}

	private void ClikedNombreMateria(object sender, EventArgs e)
	{
		entryNombreMateria.IsVisible = false;
		btnNombreMateria.IsVisible = false;
		lblNombreMateria.IsVisible = true;
		btnCalificacionNecesaria.IsVisible = !btnNombreMateria.IsVisible && !btnValoresParciales.IsVisible && !btnCalificacionParciales.IsVisible;
	}

	private void ClickedValoresParciales(object sender, EventArgs e)
	{
		entryValoresParciales.IsVisible = false;
		btnValoresParciales.IsVisible = false;
		lblValoresParciales.IsVisible = true;
		btnCalificacionNecesaria.IsVisible = !btnNombreMateria.IsVisible && !btnValoresParciales.IsVisible && !btnCalificacionParciales.IsVisible;
	}

	private void ClikedCalificacionParciales(object sender, EventArgs e)
	{
		entryCalificacionParciales.IsVisible = false;
		btnCalificacionParciales.IsVisible = false;
		lblCalificacionParciales.IsVisible = true;
		btnCalificacionNecesaria.IsVisible = !btnNombreMateria.IsVisible && !btnValoresParciales.IsVisible && !btnCalificacionParciales.IsVisible;
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

	private void ClickedReiniciarCalcularCalificacionNecesaria(object sender, EventArgs e)
	{
		entryNombreMateria.IsVisible = true;
		entryNombreMateria.Text = "";
		btnNombreMateria.IsVisible = true;
		lblNombreMateria.IsVisible = false;

		entryValoresParciales.IsVisible = true;
		entryValoresParciales.Text = "";
		btnValoresParciales.IsVisible = true;
		lblValoresParciales.IsVisible = false;

		entryCalificacionParciales.IsVisible = true;
		entryCalificacionParciales.Text = "";
		btnCalificacionParciales.IsVisible = true;
		lblCalificacionParciales.IsVisible = false;

		btnCalificacionNecesaria.IsVisible = true;
		btnReiniciarCalificacionNecesaria.IsVisible = false;
	}

	private float CalcularObjetivoCalificacion(float objetivoCalificacionFinal, float porcentajeParcial1, float calificacionParcial1, float porcentajeParcial2, float calificacionParcial2, float porcentajeParcial3)
	{
		return (objetivoCalificacionFinal - (porcentajeParcial1 / 100.0f) * calificacionParcial1 - (porcentajeParcial2 / 100.0f) * calificacionParcial2) / (porcentajeParcial3 / 100.0f);
	}

	private void ClickedCalcularCalificacionNecesaria(object sender, EventArgs e)
	{
		float[] valoresParcial = stringfloat(this.lblValoresParciales.Text);
		float[] calificacionParcial = stringfloat(this.lblCalificacionParciales.Text);

		if(valoresParcial.Sum() == 100 && calificacionParcial.All(x => x >= 0 && x <= 10)){
			lblCalificacionMinima.Text = CalcularObjetivoCalificacion(6, valoresParcial[0], calificacionParcial[0], valoresParcial[1], calificacionParcial[1], valoresParcial[2]).ToString();
			lblCalificacionMaxima.Text = CalcularObjetivoCalificacion(10, valoresParcial[0], calificacionParcial[0], valoresParcial[1], calificacionParcial[1], valoresParcial[2]).ToString();

			if(CalcularObjetivoCalificacion(10, valoresParcial[0], calificacionParcial[0], valoresParcial[1], calificacionParcial[1], valoresParcial[2]) > 10){
				lblMensajeFinal.Text = "No pudiste conseguir el diez, pero sigue esforzandote";
			}else{
				lblMensajeFinal.Text = "VAMOS TU PUEDES, VE POR EL DIEZ!!!";
			}
		}else{
			this.lblCalificacionMinima.Text = "Hay un error en el valor de los rubros o las calificaciones, revisa e intenta de nuevo";
		}
		btnCalificacionNecesaria.IsVisible = false;
		btnReiniciarCalificacionNecesaria.IsVisible = true;
	}
}