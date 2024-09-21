using Microsoft.Extensions.Logging;

namespace TDMPW_3P_PR01;

public static class MauiProgram
{
	public static MauiApp CreateMauiApp()
	{
		var builder = MauiApp.CreateBuilder();
		builder
			.UseMauiApp<App>()
			.ConfigureFonts(fonts =>
			{
				fonts.AddFont("OpenSans-Regular.ttf", "OpenSansRegular");
				fonts.AddFont("OpenSans-Semibold.ttf", "OpenSansSemibold");
				fonts.AddFont("Battipaglia.ttf", "Battipaglia");
				fonts.AddFont("Stargo.ttf", "Stargo");
				fonts.AddFont("Game-of-Thrones.ttf", "Got");
			});

#if DEBUG
		builder.Logging.AddDebug();
#endif

		return builder.Build();
	}
}
