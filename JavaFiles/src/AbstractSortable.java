abstract class AbstractSortable {

	public static void sort(Sortable[] sortables) {

		for (int x = 0; x < sortables.length - 1; x++) {
            for (int j = 0; j < sortables.length - 1; j++) {
				if (sortables[j].compareTo(sortables[j + 1])) {
					Sortable temp = sortables[j];
					sortables[j] = sortables[j + 1];
					sortables[j + 1] = temp; 
				}
			}
		}
	}
}