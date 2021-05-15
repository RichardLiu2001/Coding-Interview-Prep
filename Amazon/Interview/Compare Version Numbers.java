class Solution {
    public int compareVersion(String version1, String version2) {
        	
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");

        int longerLength = Math.max(v1.length, v2.length);

        int v1Revision;

        int v2Revision;

        for (int i = 0; i < longerLength; ++) {

        	if (i < version1.length()) {
        		v1Revision = Integer.parseInt(v1[i]);
        	} else {
        		v1Revision = 0;
        	}


        	if (i < version2.length()) {
        		v2Revision = Integer.parseInt(v2[i]);
        	} else {
        		v2Revision = 0;
        	}


        	if (v1Revision != v2Revision) {

        		return v1Revision < v2Revision ? -1 : 1;

        	}



        }

        return 0;

    }
}