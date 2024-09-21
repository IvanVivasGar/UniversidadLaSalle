using TDMPW_3P_EJ03.Views;
namespace TDMPW_3P_EJ03;

public partial class App : Application
{
	public App()
	{
		InitializeComponent();

		MainPage = new PersonaView();
	}
}
