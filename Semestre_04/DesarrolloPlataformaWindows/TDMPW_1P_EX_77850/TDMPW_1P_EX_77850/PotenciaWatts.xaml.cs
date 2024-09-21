namespace TDMPW_1P_EX_77850;

public partial class PotenciaWatts : ContentPage
{
	public PotenciaWatts()
	{
		InitializeComponent();
	}

	// Metodo que convierte el contenido del textbox a double y multiplica la cantidad de amperios por la cantidad de voltios
	// y muestra en el label resultadoConversionWatts el resultado.
	public void ConversionWatts(object sender, EventArgs s){
		this.resultadoConversionWatts.Text = double.Parse(this.cantidadAmperios.Text) * double.Parse(this.cantidadVoltios.Text);
	}
}