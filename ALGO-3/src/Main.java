public class Main {
    public static void main(String[] args) {
        int[][] regional_teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1},
        };
        int[] res = national_team(regional_teams);
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1) {
                System.out.print(res[i] + ", ");
            } else {
                System.out.print(res[i]);
            }
        }
    }

    public static int[] national_team(int[][] regional_teams) {
        int[] team = regional_teams[0];
        for (int i = 1; i < regional_teams.length; i++) {
            team = merge(team, regional_teams[i]);
        }
        return team;
    }

    public static int[] merge(int[] team, int[] regional_team) {
        int[] result = new int[10];
        int iteam = 0;
        int iregional_team = 0;
        int iresult = 0;
        // Оставил условия об окончании массива на случай если в перспективе появятся команды с меньшим чем 10 количеством игроков (вдруг кто-то травмируется,
        // может даже сразу несколько игроков), хотя в данном варианте оно является избыточным, поскольку выбирая 10 из 20, даже если одна команда на 100% сильнее
        // она просто целиком мегрирует в конечный результат.
        while (iresult < 10) {
            if (iteam == team.length) {
                result[iresult] = regional_team[iregional_team];
                iregional_team++;
                iresult++;
            } else if (iregional_team == regional_team.length) {
                result[iresult] = team[iteam];
                iteam++;
                iresult++;
            } else {
                if (team[iteam] <= regional_team[iregional_team]) {
                    result[iresult] = regional_team[iregional_team];
                    iregional_team++;
                } else {
                    result[iresult] = team[iteam];
                    iteam++;
                }
                iresult++;
            }
        }
        return result;
    }
}
