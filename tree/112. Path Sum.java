/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // void dfs(unordered_map<int, TreeNode*> &mp, TreeNode* curr, int sum)
    // {
    //     if (!curr) return;
    //     sum = sum + curr -> val;
    //     mp[sum] = curr;
    //     dfs(mp, curr->left, sum);
    //     dfs(mp, curr->right, sum);
    // }
    // bool hasPathSum(TreeNode* root, int targetSum) {
    //     unordered_map<int, TreeNode*> mp;
    //     TreeNode* curr = root;
    //     dfs(mp, curr, 0);
    //     return mp.find(targetSum) != mp.end() && mp[targetSum]->left == nullptr && mp[targetSum]->right == nullptr;
    // }
   bool hasPathSum(TreeNode* root, int sum) {
        if(!root)return false;
        if(sum==root->val&&!root->left&&!root->right)return true;
        sum-=root->val;
        if(true==hasPathSum(root->left,sum))return true;
        else{
            if(true==hasPathSum(root->right,sum))return true;
        }
        return false;
    }
};