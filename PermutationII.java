bool noSwap(const vector<int> &num, int k, int i) {
    for(int j=k; j<i; ++j) {
        if(num[j]==num[i]) return true; //see if any element from num[k] to num[i-1] is equal to num[i]. If equal, that means someone equal to num[i] has already taken this seat before. That possibility has been covered.
    }
    return false;
}

void permutationUniqueHelper(vector<int> num, int n, int k, vector<vector<int> > &res) {
    if(k==n) {
        res.push_back(num);
    } else {
        for(int i=k; i<=n; ++i) { //i<=n, n is index, vSize-1.
            if(noSwap(num, k, i)) continue; // i!=k && num[i]==num[i-1] doesn't work because permutation already disturbed the order in process
            swap(num[k], num[i]);
            permutationUniqueHelper(num, n, k+1, res);
            swap(num[k], num[i]); //if you use vector<int> &num, then you will need this line.
        }
    }
}
vector<vector<int> > permuteUnique(vector<int> &num) {
    vector<vector<int> > res;
    int vSize=num.size();
    if(vSize==0) return res;

    permutationUniqueHelper(num, vSize-1, 0, res);
    return res;
}