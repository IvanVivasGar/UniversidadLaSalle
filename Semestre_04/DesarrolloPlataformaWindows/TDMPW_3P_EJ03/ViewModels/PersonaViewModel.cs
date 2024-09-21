using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using TDMPW_3P_EJ03.Models;
namespace TDMPW_3P_EJ03.ViewModels;

public partial class PersonaViewModel : ObservableObject
{
    [ObservableProperty]
    private Person _persona;
    public PersonaViewModel(){
        Persona = new Person{Name = "Ivan", Age = 30};
    }

    [RelayCommand]
    private void ActualizarEdad()
    {
        Persona.Age += 1;
        OnPropertyChanged(nameof(Persona));
    }

    [RelayCommand]
    private void ActualizarNombre(String newName)
    {
        Persona.Name = newName;
        OnPropertyChanged(nameof(Persona));
    }
}
