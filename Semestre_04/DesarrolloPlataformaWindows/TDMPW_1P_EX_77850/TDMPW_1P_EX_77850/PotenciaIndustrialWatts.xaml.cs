namespace TDMPW_1P_EX_77850;

public partial class PotenciaIndustrialWatts : ContentPage
{
	public PotenciaIndustrialWatts()
	{
		InitializeComponent();
	}

	// Metodo que agarra la informacion del textbox, la convierte a double y divide los joules contra los segundos,
	// este se muestra en el label de resultadoConversionIndustrial
	private void ConversionIndustrial(object sender, EventArgs s){
		this.resultadoConversionIndustrial.Text = double.Parse(this.cantidadJoules.Text) / double.Parse(this.cantidadSegundos.Text);
	}
}