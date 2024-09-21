using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using TDMPW_3P_EX_77850.Models;

namespace TDMPW_3P_EX_77850.ViewModels;

public partial class MateriaViewModel : ObservableObject
{
    [ObservableProperty]
    private Materia _materia;

    public MateriaViewModel(){
        Materia = new Materia{
            Nombre = "Materia",
            Rubros = "Examen, Proyecto, Trabajos",
            ValorRubros = "30, 30, 40",
            CalificacionRubros = "10, 10, 10"
        };
    }

    [RelayCommand]
    private void ActualizarNombre(String nuevoNombre){
        Materia.Nombre = nuevoNombre;
        OnPropertyChanged(nameof(Materia));
    }

    [RelayCommand]
    private void ActualizarRubros(String nuevosRubros){
        Materia.Rubros = nuevosRubros;
        OnPropertyChanged(nameof(Materia));
    }

    [RelayCommand]
    private void ActualizarValorRubros(String nuevosValoresRubros){
        Materia.ValorRubros = nuevosValoresRubros;
        OnPropertyChanged(nameof(Materia));
    }

    [RelayCommand]
    private void ActualizarCalificacionRubros(String nuevasCalificacionesRubros){
        Materia.CalificacionRubros = nuevasCalificacionesRubros;
        OnPropertyChanged(nameof(Materia));
    }
}